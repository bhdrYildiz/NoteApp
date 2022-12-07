package com.yildiz.noteapp

import android.annotation.SuppressLint
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_rv_item.view.*

class NoteAdapter(
        val context: Context,
        val noteClickInterface: NoteClickInterface,
        val noteClickDeleteInterface : NoteClickDeleteInterface
        ) : RecyclerView.Adapter<NoteAdapter.Holder>(){

    private var allNotes = ArrayList<Notes>()
    inner class Holder (view : View) : RecyclerView.ViewHolder(view){
            val noteTv = itemView.tv_noteTitle
            val timeTv = itemView.tv_timeStamp
            //val deleteIv = itemView.img_delete

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : Holder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item,parent,false)
        return Holder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.noteTv.setText(allNotes.get(position).noteTitle)
        holder.timeTv.setText("Last Update : "+allNotes.get(position).timeStamp)



    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newlist : List<Notes>){
        allNotes.clear()
        allNotes.addAll(newlist)
        notifyDataSetChanged()
    }
    interface NoteClickInterface{
        fun onNoteClick(note : Notes)
    }
    interface NoteClickDeleteInterface{
        fun onDeleteIconClick(note : Notes)
    }
}