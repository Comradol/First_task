package bonch.dev.school.models

class Counter(startCount:Int = 0) {
    var currentCounter=startCount
    private set
    fun increment(){
        currentCounter++
    }
}