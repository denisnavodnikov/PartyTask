package ru.navodnikov.denis.partytask.ui.party

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.navodnikov.denis.domain.entity.Visitor
import ru.navodnikov.denis.partytask.R

class VisitorsRecyclerAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val islandList: MutableList<Visitor> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VisitorsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_visitors_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is VisitorsViewHolder -> {
                val visitor: Visitor = islandList[position]
                holder.bind(islandList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return islandList.size
    }

    fun setItems(excursionsList: List<Visitor>){
        this.islandList.clear()
        this.islandList.addAll(excursionsList)
        notifyDataSetChanged()
    }

    class VisitorsViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.visitor_image_view)
        private val name: TextView = itemView.findViewById(R.id.name_of_visitor_text)

        fun bind(visitor: Visitor) {
            Picasso.get().load(visitor.imageUrl).into(image)
            name.text = visitor.name
        }
    }
}