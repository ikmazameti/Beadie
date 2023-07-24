package com.ebits.beadie.data.repo

import com.ebits.beadie.data.model.User
import com.ebits.beadie.network.ApiService
import com.ebits.beadie.utils.Constant.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow

//class UserRepositoryImpl(
//    private val apiService: UserApiService
//) : UserRepository {
//
//    private val pagingConfig = PagingConfig(
//        pageSize = NETWORK_PAGE_SIZE,
//        enablePlaceholders = false
//    )
//
//    override fun getUsers(): Flow<List<User>> {
//        return Pager(
//            config = pagingConfig,
//            pagingSourceFactory = { GorestDataSource(apiService) }
//        ).flow
//    }
//}