package fiek.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {


    Context c;

    List<UserModel> dataSource = new ArrayList<>();

    public UserAdapter(Context _c){
        this.c=_c;
       /* for (int i =1;i<50;i++){
            dataSource.add(new UserModel(i,"Filan"+i,"Fisteku"+i,"Filan.fisteku"+i+"@gmai.com","123456"));
        }
*/
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataSource.get(position).getId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UsersViewHolder viewholder;
        // //
        if(convertView==null){
            convertView = LayoutInflater.from(c).inflate(R.layout.row_layout,parent,false);
            viewholder= new UsersViewHolder(convertView);
            convertView.setTag(viewholder);

        }
        else{
            viewholder=(UsersViewHolder) convertView.getTag();
        }
        if(viewholder.getRowTitle()!=null){
            viewholder.getRowTitle().setText(dataSource.get(position).getName()+" "+dataSource.get(position).getLastName() +
                    " " /*+ dataSource.get(position).getEmail() + " "+ dataSource.get(position).getPassword()*/);
            viewholder.getTvusernametitle().setText(dataSource.get(position).getEmail());
        }

        return convertView;
    }
}
