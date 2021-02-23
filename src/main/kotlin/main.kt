fun main() {

    println(format("mario", "example.com"))     //Calls a function with argument values.
    println(format("domain.com", "username"))   //Calls a function with switched arguments. No syntax errors, but the result is incorrect.
    println(format(userName = "foo", domain = "bar.com"))       //Calls a function with named arguments.
    println(format(domain = "frog.com", userName = "pepe"))     //When invoking a function with named arguments they can by in any order.

    val greeting = "Kotliner"

    println("Hello $greeting")                  //Prints a string with a variable reference. References in strings start with $.
    println("Hello ${greeting.toUpperCase()}")  //Prints a string with an expression. Expressions start with $ and are enclosed in curly braces.
}

fun format(userName: String, domain: String) = "$userName@$domain"