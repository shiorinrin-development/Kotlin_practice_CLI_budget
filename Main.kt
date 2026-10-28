data class ExpenseData(
    val ID: Int, 
    val content: String, 
    val amount: Int, 
    val category:Category
)

class BudgetManager(val dataList: MutableList<ExpenseData> = mutableListOf(), var latestID: Int = 0, val cumulativeList: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0)) {
    fun addData(content: String, amount: Int, category: Category) {
        latestID += 1
        val data = ExpenseData(latestID, content, amount, category)
        dataList.add(data)
        cumulativeList[0] += amount
        cumulativeList[category.id] += amount
        println("支出を登録しました")
        println("登録内容：$data")
    }

    fun displayData() {
        for (data in dataList) {
            println("ID: ${data.ID} | ${data.content} | ${data.amount} | ${data.category.label}")
        }
    }

    fun searchData(keyword: String) {
        var flag = false
        for (data in dataList) {
            if (keyword in data.content) {
                println(data.content)
                flag = true
            }
        if (!flag) println("該当する支出はありませんでした。")
        }
    }

    fun displaySum() {
        println("現在の支出合計は ${cumulativeList[0]}円です。")
    }
    
    fun displayCategorySum() {
        for (category in Category.entries) {
            println("${category.label}:  ${cumulativeList[category.id]}円")
        }
        println("合計:  ${cumulativeList[0]}")
    }

    fun deleteData(ID: Int) {
        var target: ExpenseData? = null
        for (data in dataList) {
            if (data.ID == ID) {
                target = data
            }
        }
        if (target != null) {
            dataList.remove(target)
            println("支出を削除しました。")
        } else println("ID: $ID の支出は存在しません。")
    }
}

enum class Category(val label: String, val id: Int) {
    FOOD("食費", 1),
    TRANSPORT("交通費", 2),
    LEISURE("娯楽費", 3),
    GOODS("日用品", 4),
    OTHER("その他", 5)
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
    val budgetManager = BudgetManager()
    while (true) {
        displayMenu(mainOptions)
        var option = readln().toIntOrNull()
        if (option == null || option >= 8 || option <= 0) {
            println("1〜7の番号で選択してください。")
        } else {
            when (option) {
                1 -> {
                    println("登録する支出の内容を入力してください。")
                    val title = readln().toStringOrNull()
                    println("登録する支出の金額を入力してください。")
                    val amount = readln().toIntOrNull()
                    println("登録するカテゴリを入力してください。")
                    val category = readln().toStringOrNull()
                }  
            }
        }
    }

    budgetManager.addData("食事（昼）", 1000, Category.FOOD)
    // budgetManager.displaySum()
    // budgetManager.addData("食事（夜）", 2000, Category.OTHER)
    // budgetManager.displayData()
    // budgetManager.searchData("昼")
    // budgetManager.searchData("夜")
    // budgetManager.displaySum()
    // budgetManager.displayCategorySum()
    budgetManager.deleteData(0)
    budgetManager.deleteData(1)
}