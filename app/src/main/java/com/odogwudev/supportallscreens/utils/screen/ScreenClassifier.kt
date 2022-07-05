package com.odogwudev.supportallscreens.utils.screen

//modelling the data
sealed interface ScreenClassifier {
    data class FullyOpened(
        val heigth: Dimension,
        val width: Dimension
    ) : ScreenClassifier
    //no need to specify type because its supposed to model the size and dp

}