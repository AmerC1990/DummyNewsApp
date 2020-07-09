package com.amercosovic.dummynews2

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.amercosovic.dummynews2.modelwithmandatorysearchonly.MandatorySearchOnly
import com.amercosovic.dummynews2.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // TextView Clicked to show Date Picker Dialog
        Enter_Begin_Date.setOnClickListener {
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{ view, Year, Month, Day ->
                    // set to textView
                    if (Day < 10 && Month <10) {
                        Enter_Begin_Date.text = "0" + Day + "/0" + Month.toInt().plus(1) + "/" + Year
                    } else if (Day < 10 && Month >= 10) {
                        Enter_Begin_Date.text = "0" + Day + "/" + Month.toInt().plus(1) + "/" + Year
                    } else if (Day >= 10 && Month < 10) {
                        Enter_Begin_Date.text = "" + Day + "/0" + Month.toInt().plus(1) + "/" + Year
                    }



                }, year, month, day)
            // show dialog
            dpd.show()
        }

        Enter_End_Date.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, Year, Month, Day ->
                    // set to textView
                    if (Day < 10 && Month <10) {
                        Enter_End_Date.text = "0" + Day + "/0" + Month.toInt().plus(1) + "/" + Year
                    } else if (Day < 10 && Month >= 10) {
                        Enter_End_Date.text = "0" + Day + "/" + Month.toInt().plus(1) + "/" + Year
                    } else if (Day >= 10 && Month < 10) {
                        Enter_End_Date.text = "" + Day + "/0" + Month.toInt().plus(1) + "/" + Year
                    }


                },
                year,
                month,
                day
            )
            // show dialog
            dpd.show()
        }

        button2.setOnClickListener {
            if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getMandatorySearchResult(query = searchQuery, api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                    val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            } else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isEmpty()) && TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val category: String = "Travel"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithCheckbox(query = searchQuery, category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isEmpty()) && !TravelTextBox.isChecked && SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val category: String = "Sports"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithCheckbox(query = searchQuery, category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val category: String = "Politics"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithCheckbox(query = searchQuery, category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val category: String = "Entrepreneurs"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithCheckbox(query = searchQuery, category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val category: String = "Business"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithCheckbox(query = searchQuery, category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val category: String = "Arts"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithCheckbox(query = searchQuery, category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isNotEmpty()
                        && Enter_End_Date.text.isEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                    val searchQuery: String = search_query_edittext.text.toString()
                    val rawBeginDate: String = Enter_Begin_Date.text.toString()
                    val beginDate: String  = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                            rawBeginDate.substringBefore("/")
                    CoroutineScope(IO).launch {
                        val result = ApiClient.getClient.getSearchResultWithBeginDateOnly(query = searchQuery, begin_date = beginDate,
                            api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                            val myResultBody: String = result.toString()
                        withContext(Main) {
                            val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                            intent.putExtra("myResult", myResultBody)
                            startActivity(intent)
                        }
                    }
            }else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isEmpty()
                        && Enter_End_Date.text.isNotEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawEndDate: String = Enter_Begin_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithEndDateOnly(
                        query = searchQuery,
                        end_date = endDate,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m"
                    )
                    val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            } else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isNotEmpty()
                        && Enter_End_Date.text.isNotEmpty()) && !TravelTextBox.isChecked && !SportsTextBox.isChecked && !PoliticsTextBox.isChecked && !EntrepreneursTextBox.isChecked && !BusinessTextBox.isChecked && !ArtsCheckBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawBeginDate: String = Enter_Begin_Date.text.toString()
                val beginDate: String = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                        rawBeginDate.substringBefore("/")
                val rawEndDate: String = Enter_End_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithBeginDateAndEndDate(query = searchQuery, begin_date = beginDate,
                        end_date = endDate,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            } else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isNotEmpty()
                        && Enter_End_Date.text.isNotEmpty()) && TravelTextBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawBeginDate: String = Enter_Begin_Date.text.toString()
                val beginDate: String = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                        rawBeginDate.substringBefore("/")
                val rawEndDate: String = Enter_End_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                val category: String = "Travel"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithBeginDateEndDateAndCheckbox(api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m",
                    begin_date = beginDate,category = category, end_date = endDate, query = searchQuery)
                    val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            } else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isNotEmpty()
                        && Enter_End_Date.text.isNotEmpty()) && SportsTextBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawBeginDate: String = Enter_Begin_Date.text.toString()
                val beginDate: String = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                        rawBeginDate.substringBefore("/")
                val rawEndDate: String = Enter_End_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                val category: String = "Sports"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithBeginDateEndDateAndCheckbox(query = searchQuery, begin_date = beginDate,
                        end_date = endDate,
                        category = category, api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isNotEmpty()
                        && Enter_End_Date.text.isNotEmpty()) && PoliticsTextBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawBeginDate: String = Enter_Begin_Date.text.toString()
                val beginDate: String = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                        rawBeginDate.substringBefore("/")
                val rawEndDate: String = Enter_End_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                val category: String = "Politics"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithBeginDateEndDateAndCheckbox(query = searchQuery,
                        begin_date = beginDate,
                        end_date = endDate,
                        category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isNotEmpty()
                        && Enter_End_Date.text.isNotEmpty()) && EntrepreneursTextBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawBeginDate: String = Enter_Begin_Date.text.toString()
                val beginDate: String = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                        rawBeginDate.substringBefore("/")
                val rawEndDate: String = Enter_End_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                val category: String = "Entrepreneurs"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithBeginDateEndDateAndCheckbox(query = searchQuery,
                        begin_date = beginDate,
                        end_date = endDate,
                        category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if ((search_query_edittext.text.isNotEmpty()
                        && Enter_Begin_Date.text.isNotEmpty()
                        && Enter_End_Date.text.isNotEmpty()) && BusinessTextBox.isChecked
            ) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawBeginDate: String = Enter_Begin_Date.text.toString()
                val beginDate: String = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                        rawBeginDate.substringBefore("/")
                val rawEndDate: String = Enter_End_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                val category: String = "Business"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithBeginDateEndDateAndCheckbox(query = searchQuery,
                        begin_date = beginDate,
                        end_date = endDate,
                        category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }
                }
            }
            else if (search_query_edittext.text.isNotEmpty()
                && Enter_Begin_Date.text.isNotEmpty()
                && Enter_End_Date.text.isNotEmpty()
                && ArtsCheckBox.isChecked == true) {
                val searchQuery: String = search_query_edittext.text.toString()
                val rawBeginDate: String = Enter_Begin_Date.text.toString()
                val beginDate: String = rawBeginDate.toString().substringAfterLast("/") + rawBeginDate.subSequence(3,5) +
                        rawBeginDate.substringBefore("/")
                val rawEndDate: String = Enter_End_Date.text.toString()
                val endDate: String = rawEndDate.toString().substringAfterLast("/") + rawEndDate.subSequence(3,5) +
                        rawEndDate.substringBefore("/")
                val category: String = "Arts"
                CoroutineScope(IO).launch {
                    val result = ApiClient.getClient.getSearchResultWithBeginDateEndDateAndCheckbox(query = searchQuery,
                        begin_date = beginDate,
                        end_date = endDate,
                        category = category,
                        api_key = "G9Xfi28dQn57YSw4gz11Smt0eBZumn6m")
                        val myResultBody: String = result.toString()
                    withContext(Main) {
                        val intent = Intent(this@MainActivity, ResultsActivity::class.java)
                        intent.putExtra("myResult", myResultBody)
                        startActivity(intent)
                    }

                }
            }
        }
    }
}


