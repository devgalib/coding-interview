package com.edureminder.interview

import android.os.Bundle
import android.util.TypedValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edureminder.interview.lib.markdown.MarkdownText
import com.edureminder.interview.lib.markdown.getMarkwon
import com.edureminder.interview.ui.theme.InterviewTheme
import io.noties.markwon.Markwon

class MainActivity : ComponentActivity() {
    private val exampleMarkdownString = """
        221. ### Can I add getters and setters using defineProperty method

          Yes, You can use the `Object.defineProperty()` method to add Getters and Setters. For example, the below counter object uses increment, decrement, add and subtract properties,
    
          ```javascript
          var obj = { counter: 0 };
    
          // Define getters
          Object.defineProperty(obj, "increment", {
            get: function () {
              this.counter++;
              return this.counter;
            },
          });
          Object.defineProperty(obj, "decrement", {
            get: function () {
              this.counter--;
              return this.counter;
            },
          });
    
          // Define setters
          Object.defineProperty(obj, "add", {
            set: function (value) {
              this.counter += value;
            },
          });
          Object.defineProperty(obj, "subtract", {
            set: function (value) {
              this.counter -= value;
            },
          });
    
          obj.add = 10;
          obj.subtract = 5;
          console.log(obj.increment); //6
          console.log(obj.decrement); //5
          ```
    
          **[⬆ Back to Top](#table-of-contents)**
    
        222. ### What is the purpose of switch-case
        
              The `switch case` statement in JavaScript is used for decision making purposes. In a few cases, using the `switch case` statement is going to be more convenient than `if-else` statements. The syntax would be as below,
        
              ```javascript
              switch (expression)
              {
                  case value1:
                      statement1;
                      break;
                  case value2:
                      statement2;
                      break;
                  .
                  .
                  case valueN:
                      statementN;
                      break;
                  default:
                      statementDefault;
              }
              ```
        
              The above multi-way branch statement provides an easy way to dispatch execution to different parts of code based on the value of the expression.
        
              **[⬆ Back to Top](#table-of-contents)**
        
        223. ### What are the conventions to be followed for the usage of switch case
        
              Below are the list of conventions should be taken care,
        
              1. The expression can be of type either number or string.
              2. Duplicate values are not allowed for the expression.
              3. The default statement is optional. If the expression passed to switch does not match with any case value then the statement within default case will be executed.
              4. The break statement is used inside the switch to terminate a statement sequence.
              5. The break statement is optional. But if it is omitted, the execution will continue on into the next case.
        
              **[⬆ Back to Top](#table-of-contents)**
        
        224. ### What are primitive data types
        
              A primitive data type is data that has a primitive value (which has no properties or methods). There are 7 types of primitive data types.
        
              1. string
              2. number
              3. boolean
              4. null
              5. undefined
              6. bigint
              7. symbol
        
              **[⬆ Back to Top](#table-of-contents)**
        
        225. ### What are the different ways to access object properties
        
              There are 3 possible ways for accessing the property of an object.
        
              1. **Dot notation:** It uses dot for accessing the properties
        
              ```javascript
              objectName.property;
              ```
        
              2. **Square brackets notation:** It uses square brackets for property access
        
              ```javascript
              objectName["property"];
              ```
        
              3. **Expression notation:** It uses expression in the square brackets
        
              ```javascript
              objectName[expression];
              ```
        
              **[⬆ Back to Top](#table-of-contents)**
        
        226. ### What are the function parameter rules
        
              JavaScript functions follow below rules for parameters,
        
              1. The function definitions do not specify data types for parameters.
              2. Do not perform type checking on the passed arguments.
              3. Do not check the number of arguments received.
                 i.e, The below function follows the above rules,
        
              ```javascript
              function functionName(parameter1, parameter2, parameter3) {
                console.log(parameter1); // 1
              }
              functionName(1);
              ```
        
              **[⬆ Back to Top](#table-of-contents)**
        
        227. ### What is an error object
        
              An error object is a built in error object that provides error information when an error occurs. It has two properties: name and message. For example, the below function logs error details,
        
              ```javascript
              try {
                greeting("Welcome");
              } catch (err) {
                console.log(err.name + "<br>" + err.message);
              }
              ```
        
              **[⬆ Back to Top](#table-of-contents)**
        
        228. ### When do you get a syntax error
        
              A SyntaxError is thrown if you try to evaluate code with a syntax error. For example, the below missing quote for the function parameter throws a syntax error
        
              ```javascript
              try {
                eval("greeting('welcome)"); // Missing ' will produce an error
              } catch (err) {
                console.log(err.name);
              }
              ```
        
              **[⬆ Back to Top](#table-of-contents)**
        
        229. ### What are the different error names from error object
        
              There are 7 different types of error names returned from error object,
              | Error Name | Description |
              |---- | ---------
              | `AggregateError` | An error indicating that multiple errors occurred |
              | `EvalError` | An error has occurred in the eval() function |
              | `RangeError` | An error has occurred with a number "out of range" |
              | `ReferenceError` | An error due to an illegal reference|
              | `SyntaxError` | An error due to a syntax error|
              | `TypeError` | An error due to a type error |
              | `URIError` | An error due to encodeURI() |
        
              **[⬆ Back to Top](#table-of-contents)**
        
        230. ### What are the various statements in error handling
        
              Below are the list of statements used in an error handling,
        
              1. **try:** This statement is used to test a block of code for errors
              2. **catch:** This statement is used to handle the error
              3. **throw:** This statement is used to create custom errors.
              4. **finally:** This statement is used to execute code after try and catch regardless of the result.
        
              **[⬆ Back to Top](#table-of-contents)**
        
        231. ### What are the two types of loops in javascript
        
              1. **Entry Controlled loops:** In this kind of loop type, the test condition is tested before entering the loop body. For example, For Loop and While Loop comes under this category.
              2. **Exit Controlled Loops:** In this kind of loop type, the test condition is tested or evaluated at the end of the loop body. i.e, the loop body will execute at least once irrespective of test condition true or false. For example, do-while loop comes under this category.
        
              **[⬆ Back to Top](#table-of-contents)**
    """.trimIndent()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val markwon: Markwon = getMarkwon(
            this,
            codeFontSizePx = spToPx(12f)
        )

        setContent {
            InterviewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        var markdownString by remember { mutableStateOf(exampleMarkdownString) }
                        MarkdownText(
                            markdownString,
                            markwon,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                        )
                    }
                }
            }
        }
    }
    private fun spToPx(sp: Float): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics).toInt()

}
