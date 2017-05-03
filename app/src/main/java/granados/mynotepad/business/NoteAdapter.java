package granados.mynotepad.business;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import granados.mynotepad.R;
import granados.mynotepad.models.Note;

/**
 * Created by Steph on 2/05/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> notes;

    public NoteAdapter(List<Note> notes){
        this.notes = notes;
    }

public void setNotes(List<Note> notes) {
        this.notes = notes;
        }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, int position) {
        Note note = this.notes.get(position);
        viewHolder.title.setText(note.getTitle());
        viewHolder.type.setText(note.getType());
        viewHolder.description.setText(note.getDescription());

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView trash;
        public TextView title;
        public TextView type;
        public TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            trash = (ImageView) itemView.findViewById(R.id.trash);
            title = (TextView) itemView.findViewById(R.id.title_text);
            type = (TextView) itemView.findViewById(R.id.type_text);
            description = (TextView) itemView.findViewById(R.id.description_text);
        }
    }

}
