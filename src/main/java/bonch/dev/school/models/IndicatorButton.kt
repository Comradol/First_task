package bonch.dev.school.models

class IndicatorButton(startLogic:Boolean=false) {
    var currentIndicator=startLogic
    private set
    fun negative(){
        currentIndicator=!currentIndicator
    }

}