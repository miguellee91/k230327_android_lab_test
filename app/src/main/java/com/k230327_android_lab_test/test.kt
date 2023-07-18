package com.k230327_android_lab_test

val data5 : Int = 1  //data5는 객체 즉 .연산자를 통해서 멤버에 접근 가능
val data4 : Int by lazy {
    println("in lazy.....순서2")
    10
}


//fun main(){
//    println("in main 순서1")
//    println("data4 사용하기 순서 3: $data4")
//
//    var data6 : Int? = 2  // 널을 허용할 수 있는 연산자가 있을 때만 ?는 Null 허용 연산자(nullable)
//    data6 = null
//
//    //Array 선언, 세터, 게터
//    val data1: Array<Int> = Array(3, {0})
//    data1[0] = 10
//    data1[1] = 20
//    data1.set(2,30)
//    println(
//        """
//	    data1의 사이즈 : ${data1.size}
//        data1의 요소: ${data1[0]},${data1[1]},${data1[2]}
//	""".trimIndent())
//
//
//}



fun hofFun(arg: (Int) -> Boolean): () -> String {
    val result = if(arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}
fun main() {
    val result = hofFun({no -> no > 0})
    println(result())
}