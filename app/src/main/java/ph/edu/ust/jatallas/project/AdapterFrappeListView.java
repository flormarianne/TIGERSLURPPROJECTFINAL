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

public class AdapterFrappeListView extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<ModelFrappe> modelfrappelist;
    ArrayList<ModelFrappe> arrayList;

    //constructor
    public AdapterFrappeListView(Context context, List<ModelFrappe> modelfrappelist) {
        mContext = context;
        this.modelfrappelist = modelfrappelist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ModelFrappe>();
        this.arrayList.addAll(modelfrappelist);

    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modelfrappelist.size();
    }

    @Override
    public Object getItem(int i) {
        return modelfrappelist.get(i);
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
            view = inflater.inflate(R.layout.frappe_list, null);

            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);
        }

        else {
            holder = (ViewHolder)view.getTag();
        }

        //set results in text view
        holder.mTitleTv.setText(modelfrappelist.get(position).getTitle());
        holder.mDescTv.setText(modelfrappelist.get(position).getDesc());
        //set results in imageview
        holder.mIconIv.setImageResource(modelfrappelist.get(position).getIcon());

        //listview item clicks
        //view.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View view) {
        //code later
        //  if (modelfrappelist.get(position).getTitle().equals("Gong Cha UST The One")){
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
        modelfrappelist.clear();
        if (charText.length()==0){
            modelfrappelist.addAll(arrayList);
        }
        else {
            for (ModelFrappe modelFrappe : arrayList) {
                if (modelFrappe.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    modelfrappelist.add(modelFrappe);
                }
            }
        }
        notifyDataSetChanged();
    }


}
