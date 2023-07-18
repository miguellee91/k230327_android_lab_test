package com.k230327_android_lab_test

import java.util.Scanner

//User 클래스 정의 - 데이터 클래스
data class User(val id: String, val pw: String, val email: String, val phone: String)

// 로그인 처리 클래스 정의
class LoginHandler(private val users: List<User>) {
    fun login(id: String, pw: String): User? {
        //입력받은 ID, PW와 일치하는 유저를 찾아 반환
        return users.find {it.id == id && it.pw ==pw}
    }
}

//Register 처리 클래스 정의
class RegisterHandler(private val users: MutableList<User>){
    fun register(): User{
        val scanner = Scanner(System.`in`)
        print("ID: ")
        val id = scanner.nextLine()
        print("PW")
        val pw = scanner.nextLine()
        print("Email: ")
        val email = scanner.nextLine()
        print("Phone: ")
        val phone = scanner.nextLine()

        val newUser = User(id, pw, email, phone)
        users.add(newUser)
        return newUser
    }
}

fun main(){
    val dummyUsers =  mutableListOf(User("admin", "1234", "admin@test.com", "123-2365-4565" ))
    val loginHandler = LoginHandler(dummyUsers)
    val registerHandler = RegisterHandler(dummyUsers)

    //새로운 더미 데이터
    dummyUsers.add(User("이승민","1234","smlee@test.com"," 123-3434-2333" ))
    dummyUsers.add(User("miguellee","1234", "miguellee@test.com", "123-2233-3222"))


    println("<회원가입 및 로그인 테스트>")

    //회원 가입
    println("로그인 정보를 입력해주세요")
    print("ID: ")
    val loginID = readLine() ?: ""
    print("PW: ")
    val loginPw = readLine() ?: ""


    val loggedInUser = loginHandler.login(loginID, loginPw)
    if (loggedInUser != null) {
        println("로그인 성공")
        println("로그인한 사용자 정보:")
        println("ID: ${loggedInUser.id}")
        println("Email: ${loggedInUser.email}")
        println("Phone: ${loggedInUser.phone}")
    }else{
        println("로그인 실패: ID 또는 PW가 일치하지 않습니다.")
    }

    //전체 더미 유저 목록
    println("사용자 목록")
    for (user in dummyUsers){
        println("ID: ${user.id}, Email: ${user.email}, Phone: ${user.phone} ")
    }
}