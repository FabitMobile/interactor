package ru.fabit.interactor.usecase


import io.reactivex.Observable
import org.jetbrains.annotations.NotNull


abstract class ObservableUseCase<Params, ReturnType> : BaseUseCase<ReturnType>() {

    /**
     * @param params use EmptyParams object if useCase without params
     */
    abstract fun buildUseCaseObservable(@NotNull params: Params): Observable<ReturnType>

}