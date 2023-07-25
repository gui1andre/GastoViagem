package br.com.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)


        binding.editDistance
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_calculate){
            calculate()
        }

    }

    private fun calculate(){
        if(isValid()){
        val distance = binding.editDistance.text.toString().toFloat()
        val price = binding.editPrice.text.toString().toFloat()
        val autonomy = binding.editAutonomy.text.toString().toFloat()

        val totalValue = (distance * price) / autonomy

        binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        } else{
            Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun isValid(): Boolean{
        return (binding.editDistance.text.isNotEmpty()
                && binding.editDistance.text.isNotEmpty()
                && binding.editPrice.text.isNotEmpty()
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

}