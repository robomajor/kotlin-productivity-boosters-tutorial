fun main() {

    println(format("mario", "example.com"))     //Calls a function with argument values.
    println(format("domain.com", "username"))   //Calls a function with switched arguments. No syntax errors, but the result is incorrect.
    println(format(userName = "foo", domain = "bar.com"))       //Calls a function with named arguments.
    println(format(domain = "frog.com", userName = "pepe"))     //When invoking a function with named arguments they can by in any order.

}

fun format(userName: String, domain: String) = "$userName@$domain"