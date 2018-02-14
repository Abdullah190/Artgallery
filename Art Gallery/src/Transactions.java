public class Transactions {


        private String customerId;
        private String paintingId;
        private double sellingPrice;
        public String getCustomerId() {
            return customerId;
        }
        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }
        public String getPaintingId() {
            return paintingId;
        }
        public void setPaintingId(String paintingId) {
            this.paintingId = paintingId;
        }
        public double getSellingPrice() {
            return sellingPrice;
        }
        public void setSellingPrice(double sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        public String toString(){
            return paintingId + "," +customerId +","+sellingPrice +",";
        }


}
