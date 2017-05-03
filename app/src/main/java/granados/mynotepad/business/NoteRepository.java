package granados.mynotepad.business;

import com.orm.SugarRecord;

import java.util.List;

import granados.mynotepad.models.Note;

public class NoteRepository {

    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static Note read(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        return note;
    }

    public static void create(String title, String type, String description){
        Note note = new Note(title, type, description);
        SugarRecord.save(note);
    }

    public static void update(String title, String type, String description, Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.setTitle(title);
        note.setType(type);
        note.setDescription(description);
        SugarRecord.save(note);
    }

    public static void delete(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        SugarRecord.delete(note);
    }

}