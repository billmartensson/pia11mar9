package se.magictechnology.pia11mar9

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LoginHelper.fancytext = "Banan"
        Log.i("PIA11DEBUG", "START")
        Log.i("PIA11DEBUG", LoginHelper.fancytext)

        view.findViewById<TextView>(R.id.startTV).text = LoginHelper.username.value

        view.findViewById<Button>(R.id.logoutButton).setOnClickListener {
            LoginHelper.logout(requireContext())
        }

        view.findViewById<Button>(R.id.goReadmoreButton).setOnClickListener {
            view.findNavController().navigate(R.id.action_startFragment_to_readmoreFragment)
        }


        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            val number1 = view.findViewById<EditText>(R.id.startNumber1ET).text.toString()
            val number2 = view.findViewById<EditText>(R.id.startNumber2ET).text.toString()

            /*
            // DÅLIGT!!
            var n1 = 0
            if(number1 == "zero") {
                n1 = 0
            }
            if(number1 == "one") {
                n1 = 1
            }
            */
            /*
            var n1 = textToNumber(number1)
            var n2 = textToNumber(number2)

            var result = numberToText(n1 + n2)

            val resultNumber = result
            */

            var calchelp = CalcHelper()
            calchelp.loadNumbers()

            /*
            val n1 = calchelp.textToNumber(number1)
            val n2 = calchelp.textToNumber(number2)

            val resultNumber = calchelp.numberToText(n1 + n2)
            */
            view.findViewById<TextView>(R.id.startResultTV).text = calchelp.calcStrings(number1, number2)
        }

    }

    fun textToNumber(number : String) : Int {
        var result = 0
        when(number.lowercase()) {
            "zero" -> result = 0
            "one" -> result = 1
            "two" -> result = 2
        }

        return result
    }

    fun numberToText(number : Int) : String {
        var result = ""
        when(number) {
            0 -> result = "zero"
            1 -> result = "one"
            2 -> result = "two"
        }

        return result
    }

}

