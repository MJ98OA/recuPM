package com.example.recupm
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recupm.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var listaPalabra= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.aniadir.setOnClickListener {
            if(binding.edT.text.isEmpty())
                Toast.makeText(this,"Introduce algo primero",Toast.LENGTH_SHORT).show()
            else{
                listaPalabra.add(binding.edT.text.toString())
                binding.edT.text.clear()
            }

        }

        binding.ordeninserccion.setOnClickListener {

            var texto:String=listaPalabra.toString()
            binding.tVW.text="$texto"
        }

        binding.ordentamanio.setOnClickListener {

            binding.tVW.text= (listaPalabra.sortedByDescending { it.length } as MutableList<String>).toString()

        }

        binding.pares.setOnClickListener {

            binding.tVW.text= (listaPalabra.filter { it.length%2==0 } as MutableList<String>).toString()
        }

        binding.borrarmayores.setOnClickListener {
            listaPalabra= listaPalabra.filter { it.length>3 } as MutableList<String>
            binding.tVW.text=listaPalabra.toString()
        }



    }
}