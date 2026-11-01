package com.example.mytodolist;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;

import com.example.mytodolist.databinding.ItemTaskBinding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class TaskAdapter extends ListAdapter<Task, TaskAdapter.TaskViewHolder> {

    public interface OnTaskListener {
        void onTaskClick(Task task);

        void onTaskToggle(Task task);
    }

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM", new Locale("ro"));

    private static final DiffUtil.ItemCallback<Task> DIFF_CALLBACK = new DiffUtil.ItemCallback<Task>() {
        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.isTerminat() == newItem.isTerminat()
                    && Objects.equals(oldItem.getTitlu(), newItem.getTitlu())
                    && Objects.equals(oldItem.getUrgenta(), newItem.getUrgenta())
                    && Objects.equals(oldItem.getData_terminare(), newItem.getData_terminare());
        }
    };

    private final OnTaskListener listener;

    public TaskAdapter(OnTaskListener listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTaskBinding binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TaskViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bind(getItem(position), listener);
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {

        private final ItemTaskBinding binding;

        TaskViewHolder(ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Task task, OnTaskListener listener) {
            binding.tvTitlu.setText(task.getTitlu());

            binding.ivCheck.setImageResource(task.isTerminat()
                    ? R.drawable.ic_check_circle_filled
                    : R.drawable.ic_check_circle_outline);
            tint(binding.ivCheck, R.color.accent_pink);

            bindUrgenta(task.getUrgenta());
            bindData(task.getData_terminare());

            binding.ivCheck.setOnClickListener(v -> listener.onTaskToggle(task));
            binding.getRoot().setOnClickListener(v -> listener.onTaskClick(task));
        }

        private void bindUrgenta(Nivel nivel) {
            @DrawableRes int icon = R.drawable.ic_star;
            @ColorRes int color = R.color.accent_cyan;

            if (nivel != null) {
                switch (nivel) {
                    case HIGH:
                        icon = R.drawable.ic_flag;
                        color = R.color.accent_pink;
                        break;
                    case MEDIUM:
                        icon = R.drawable.ic_star;
                        color = R.color.accent_pink;
                        break;
                    case LOW:
                        icon = R.drawable.ic_flag;
                        color = R.color.accent_cyan;
                        break;
                }
            }

            binding.ivUrgenta.setImageResource(icon);
            tint(binding.ivUrgenta, color);
        }

        private void bindData(LocalDate data) {
            boolean visible = data != null;
            binding.tvOra.setVisibility(visible ? android.view.View.VISIBLE : android.view.View.GONE);
            binding.ivClock.setVisibility(visible ? android.view.View.VISIBLE : android.view.View.GONE);
            if (visible) {
                binding.tvOra.setText(data.format(DATE_FORMAT));
            }
        }

        private void tint(android.widget.ImageView view, @ColorRes int color) {
            ImageViewCompat.setImageTintList(view,
                    ColorStateList.valueOf(ContextCompat.getColor(view.getContext(), color)));
        }
    }
}