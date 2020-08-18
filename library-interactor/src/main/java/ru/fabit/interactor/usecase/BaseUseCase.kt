package ru.fabit.interactor.usecase

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function
import ru.fabit.error.NoNetworkConnectionException
import ru.fabit.error.RequestTimeoutError


abstract class BaseUseCase<ReturnType> {

    fun onErrorResumeNextTransformer(
        onNetworkErrorObservable: Observable<ReturnType>
    ): ObservableTransformer<ReturnType, ReturnType> {
        return ObservableTransformer { observable ->
            observable.onErrorResumeNext(Function { throwable ->
                throwable.printStackTrace()
                when (throwable) {
                    is NoNetworkConnectionException -> onNetworkErrorObservable
                    is RequestTimeoutError -> onNetworkErrorObservable
                    else -> Observable.error<ReturnType>(throwable)
                }
            })
        }
    }

}