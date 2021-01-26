package com.example.sambo.data.model.cammon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.sambo.data.model.home_courses.CoursesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class DataBase <T>(
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, T>() {

    abstract fun getListByPageNumber( limit: Int,page : Int ) : CoursesModel<T>?

    private val offset = 20
    private val limit = 20

    class Factory<T, D : DataBase<T>>(private val factory: () -> D) :
        DataSource.Factory<Int, T>(){

        private val dataSourceFactoryLiveData = MutableLiveData<DataBase<T>>()
        override fun create() = factory().apply { dataSourceFactoryLiveData.postValue(this) }
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, T>
    ) {
        scope.launch(Dispatchers.IO){
            kotlin.runCatching {
                val result = getListByPageNumber( limit = limit,page = 0 )
                result?.rows?.let { callback.onResult(it,0, 1) }
            }.onFailure {
                Log.d("dgsgsdg", "fssfsf")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        scope.launch(Dispatchers.IO){
            kotlin.runCatching {
                val result = getListByPageNumber(page = 20 * params.key, limit = limit)
                result?.rows?.let { callback.onResult(it, params.key + 1) }
            }
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
    }
}
