package com.niraj.learn;

/**
 * Created by niraj on 26/9/17.
 */



        import java.util.ArrayList;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<BookModel> {

    private final Context context;
    private final ArrayList<BookModel> bookArrayList;

    public MyAdapter(Context context, ArrayList<BookModel> bookArrayList) {

        super(context, R.layout.row, bookArrayList);

        this.context = context;
        this.bookArrayList = bookArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // 3. Get the two text view from the rowView
        TextView bname = (TextView) rowView.findViewById(R.id.bookname);
        TextView sub = (TextView) rowView.findViewById(R.id.subject);

        // 4. Set the text for textView
        bname.setText(bookArrayList.get(position).getBookname());
        sub.setText(bookArrayList.get(position).getSubject());

        // 5. return rowView
        return rowView;
    }

    @Override
    public int getCount() {
        return bookArrayList.size();
    }

    @Override
    public BookModel getItem(int position) {
        return bookArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
