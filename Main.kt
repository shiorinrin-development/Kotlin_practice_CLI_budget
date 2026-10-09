data class ExpenseData(
    val ID: Int, 
    val content: String, 
    val amount: Int, 
    val category:Category
)

class BudgetManager(val dataList: MutableList<ExpenseData>) {
    fun displayData() {
        for (data in dataList) {
            println("ID: $data.ID.toString() | $data.content | $data.amount.toString() | $data.category")
        }
    }
}

enum class Category {
    "食費",
    "交通費",
    "娯楽費",
    "日用品",
    "その他"
}

val mainOptions: List<String> = listOf("支出を登録", "支出一覧", "支出を検索", "合計金額を表示", "カテゴリ別集計", "支出を削除", "終了")
val categoryOptions: List<String> = listOf("食費", "交通費", "娯楽費", "日用品", "その他")

fun displayMenu(options: List<String>) {
    for (i in 1..options.size) {
        println("$i. ${options[i-1]}")
    }
}

fun main() {
    println("== Expense Manager == ")
    displayMenu(mainOptions)
}