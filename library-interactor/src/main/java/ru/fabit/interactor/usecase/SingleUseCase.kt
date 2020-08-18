package ru.fabit.interactor.usecase


import io.reactivex.Single
import org.jetbrains.annotations.NotNull

abstract class SingleUseCase<Params, ReturnType> : BaseUseCase<ReturnType>() {

    /**
     * @param params use EmptyParams object if useCase without params
     */
    abstract fun buildUseCaseSingle(@NotNull params: Params): Single<ReturnType>

}