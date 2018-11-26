package ph.edu.ust.jatallas.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdapterAlcoholListView extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<ModelAlcohol> modelalcohollist;
    ArrayList<ModelAlcohol> arrayList;

    //constructor
    public AdapterAlcoholListView(Context context, List<ModelAlcohol> modelalcohollist) {
        mContext = context;
        this.modelalcohollist = modelalcohollist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ModelAlcohol>();
        this.arrayList.addAll(modelalcohollist);

    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modelalcohollist.size();
    }

    @Override
    public Object getItem(int i) {
        return modelalcohollist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.alcohol_list, null);

            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);
        }

        else {
            holder = (ViewHolder)view.getTag();
        }

        //set results in text view
        holder.mTitleTv.setText(modelalcohollist.get(position).getTitle());
        holder.mDescTv.setText(modelalcohollist.get(position).getDesc());
        //set results in imageview
        holder.mIconIv.setImageResource(modelalcohollist.get(position).getIcon());

        //listview item clicks
        //view.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View view) {
        //code later
        //  if (modelalcohollist.get(position).getTitle().equals("Gong Cha UST The One")){
        //new page
        //Intent intent = new Intent(mContext, Welcomepage.class);
        //intent.putExtra("actionBarTitle", "Gong Cha UST The One");
        //intent.putExtra("contentTv", "Location: Food Court, Second Floor, The One Grand Centre, España");
        //mContext.startActivity(intent);
        //    }
        // }
        // });

        return view;

    }

    //filter
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        modelalcohollist.clear();
        if (charText.length()==0){
            modelalcohollist.addAll(arrayList);
        }
        else {
            for (ModelAlcohol modelAlcohol : arrayList) {
                if (modelAlcohol.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    modelalcohollist.add(modelAlcohol);
                }
            }
        }
        notifyDataSetChanged();
    }


}
