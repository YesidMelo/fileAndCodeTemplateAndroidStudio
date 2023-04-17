package ${PACKAGE_NAME}.views.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ${PACKAGE_NAME}.R
import ${PACKAGE_NAME}.models.Cat
import com.squareup.picasso.Picasso

class Adapter (val list: List<Cat>): RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_cats, parent, false)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.fill(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class Holder(private val view: View): RecyclerView.ViewHolder(view) {
        fun fill(cat: Cat) {
            view.findViewById<TextView>(R.id.textView_nameBreed).text = cat.breedName
            view.findViewById<TextView>(R.id.textView_countryOrigin).text = cat.origin
            view.findViewById<TextView>(R.id.textView_intelligy).text = cat.intelligence
            Picasso.get().load("https://cdn2.thecatapi.com/images/${cat.imageUrl}.jpg").into(view.findViewById<ImageView>(R.id.imageView_phothoCat))
        }
    }
}