package ${PACKAGE_NAME}.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ${PACKAGE_NAME}.databinding.ActivityMainBinding
import ${PACKAGE_NAME}.models.Cat
import ${PACKAGE_NAME}.viewmodels.ListCatsViewModel
import ${PACKAGE_NAME}.views.lists.Adapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listCatsViewModel: ListCatsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listCatsViewModel = ListCatsViewModel()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadListCats()
    }

    fun loadListCats() {
        listCatsViewModel.getCatsLivData().observe(this, {
            listCats ->
            val finalList = if(listCats == null) emptyList<Cat>() else listCats
            binding.recyclerviewListcats.adapter = Adapter(list = finalList)
            binding.recyclerviewListcats.layoutManager= LinearLayoutManager(this)
            binding.recyclerviewListcats.setHasFixedSize(true)
        })
        listCatsViewModel.loadListCats()
    }

}