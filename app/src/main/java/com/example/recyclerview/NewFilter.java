    package com.example.recyclerview;

    import android.widget.Filter;

    import androidx.recyclerview.widget.RecyclerView;

    import java.util.ArrayList;
    import java.util.List;

    import beans.Star;

    public class NewFilter extends Filter {
        private List<Star> stars;
        private List<Star> starsFilter;

        public RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

        public NewFilter() {
        }
        public NewFilter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, List<Star> stars, List<Star> starsFilter) {
            this.mAdapter = adapter;
            this.stars = new ArrayList<>(stars); // Initialize the stars list
            this.starsFilter = new ArrayList<>(starsFilter); // Initialize the starsFilter list
        }

        public NewFilter(RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter) {
            super();
            this.mAdapter = mAdapter;
        }

        public NewFilter(StarAdapter starAdapter, List<Star> stars, List<Star> starsFilter) {

        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Star> filteredList = new ArrayList<>();
            FilterResults results = new FilterResults();
            if (stars == null) {
                results.values = null;
                results.count = 0;
                return results;
            }
            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(stars);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Star star : stars) {
                    if (star.getName() != null && star.getName().toLowerCase().startsWith(filterPattern)) {
                        filteredList.add(star);
                    }
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }





        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            starsFilter = (List<Star>) filterResults.values;
            if (mAdapter != null) {
                mAdapter.notifyDataSetChanged();
            }
        }
    }

