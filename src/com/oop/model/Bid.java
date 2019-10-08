package com.oop.model;

public class Bid {

		String BidID;
		String BidPrice;
		
		
		public String getBidID() {
			return BidID;
		}
		public void setBidID(String bidId) {
			BidID = bidId;
		}
		public String getBidPrice() {
			return BidPrice;
		}
		public void setBidPrice(String bidPrice) {
			BidPrice = bidPrice;
		}
		@Override
		public String toString() {
			
			return "BidId=" + BidID + ", BidPrice=" + BidPrice;
		}
		
		
}
