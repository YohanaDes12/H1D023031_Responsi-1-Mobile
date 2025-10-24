package com.unsoed.responsi1mobileh1d023031.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d023031.data.model.Squad
import com.unsoed.responsi1mobileh1d023031.databinding.ListSquadBinding
import com.unsoed.responsi1mobileh1d023031.R

class SquadAdapter(
    private val listener: OnSquadClickListener
) : ListAdapter<Squad, SquadAdapter.ViewHolder>(DiffCallback) {

    interface OnSquadClickListener {
        fun onSquadClick(squad: Squad)
    }

    class ViewHolder(
        private val binding: ListSquadBinding,
        private val listener: OnSquadClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(squad: Squad) {
            binding.tvSquadName.text = squad.name
            binding.tvSquadNationality.text = squad.nationality

            binding.cardViewSquad.setOnClickListener {
                listener.onSquadClick(squad)
            }

            val positionColor = getPositionColor(binding.root.context, squad.position)
            binding.cardViewSquad.setCardBackgroundColor(positionColor)
        }

        private fun getPositionColor(context: Context, position: String?): Int {
            val safePosition = position.orEmpty()

            val colorResId = when {
                safePosition.contains("Goalkeeper", ignoreCase = true) -> R.color.position_goalkeeper

                safePosition.contains("Back", ignoreCase = true) ||
                        safePosition.contains("Defender", ignoreCase = true) ||
                        safePosition.contains("Defence", ignoreCase = true) -> R.color.position_defender

                safePosition.contains("Midfield", ignoreCase = true) -> R.color.position_midfielder

                safePosition.contains("Forward", ignoreCase = true) ||
                        safePosition.contains("Winger", ignoreCase = true) ||
                        safePosition.contains("Offence", ignoreCase = true) -> R.color.position_forward

                else -> R.color.position_default
            }
            return ContextCompat.getColor(context, colorResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListSquadBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Squad>() {
        override fun areItemsTheSame(oldItem: Squad, newItem: Squad) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Squad, newItem: Squad) = oldItem == newItem
    }
}