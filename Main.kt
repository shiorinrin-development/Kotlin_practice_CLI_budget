data class ExpenseData(
    val ID: Int, 
    val content: String, 
    val amount: Int, 
    val category:Category
)

class BudgetManager(val dataList: MutableList<ExpenseData> = mutableListOf(), var latestID: Int = 0) {
    fun addData(content: String, amount: Int, category: Category) {
        latestID += 1
        val data = ExpenseData(latestID, content, amount, category)
        dataList.add(data)
        println("支出を登録しました")
        println("登録内容：$data")
    }

    fun displayData() {
        for (data in dataList) {
            println("ID: ${data.ID} | ${data.content} | ${data.amount} | ${data.category.label}")
        }
    }
}

enum class Category(val label: String) {
    FOOD("食費"),
    TRANSPORT("交通費"),
    LEISURE("娯楽費"),
    GOODS("日用品"),
    OTEHR("その他")
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
    val budgetManager = BudgetManager()
    budgetManager.addData("ランチ", 1000, Category.FOOD)
    budgetManager.displayData()
}