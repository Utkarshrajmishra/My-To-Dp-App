package com.example.myto_dolist



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, val listener:INotesItemClicked) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>(){
    val allNotes =ArrayList<Note>()


    inner class NoteViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){

        val textView= itemView.findViewById<TextView>(R.id.text)
        val deleteButton= itemView.findViewById<ImageView>(R.id.deleteButtom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_note, parent, false
            )
        )
        viewHolder.deleteButton.setOnClickListener {
            allNotes[viewHolder.adapterPosition]
        }


        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return  allNotes.size
    }
    fun updateList(newList: List<Note>)
    {
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}
interface INotesItemClicked {
    fun onItemClicked(note: Note)
}