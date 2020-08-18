package ru.fabit.interactor.usecase

import io.reactivex.Completable
import org.jetbrains.annotations.NotNull


abstract class CompletableUseCase<Params> : BaseUseCase<Params>() {

    /**
     * @param params use EmptyParams object if useCase without params
     */
    abstract fun buildUseCaseCompletable(@NotNull params: Params): Completable

}