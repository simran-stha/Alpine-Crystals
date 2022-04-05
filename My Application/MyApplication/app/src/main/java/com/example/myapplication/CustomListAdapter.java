package com.example.myapplication;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

   public class CustomListAdapter  extends BaseAdapter {

        private List<Crystals> listData;
        private LayoutInflater layoutInflater;
        private Context context;

        public CustomListAdapter(Context aContext,  List<Crystals> listData) {
            this.context = aContext;
            this.listData = listData;
            layoutInflater = LayoutInflater.from(aContext);
        }

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
                holder = new ViewHolder();
                holder.imageView = (ImageView) convertView.findViewById(R.id.imageView_crystals);
                holder.crystalNameView = (TextView) convertView.findViewById(R.id.textView_crystalName);
                holder.birthmonthView = (TextView) convertView.findViewById(R.id.textView_birthmonth);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Crystals crystals = this.listData.get(position);
            holder.crystalNameView.setText(crystals.getCrystalsName());
            holder.birthmonthView.setText("BirthMonth: " + crystals.getBirthmonth());

            int imageId = this.getMipmapResIdByName(crystals.getImageName());

            holder.imageView.setImageResource(imageId);

            return convertView;
        }

        // Find Image ID corresponding to the name of the image (in the directory mipmap).
        public int getMipmapResIdByName(String resName)  {
            String pkgName = context.getPackageName();
            // Return 0 if not found.
            int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
            Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
            return resID;
        }

        static class ViewHolder {
            ImageView imageView;
            TextView crystalNameView;
            TextView birthmonthView;
        }

    }


