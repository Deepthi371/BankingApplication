package com.bankingapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.bankingapp.utils.Credentials;

public class Model {
	private int uid;
	private String uname;
	private int accno;
	private String email;
	private long phn;
	private int balance;
	private String password;
	private String npassword;
	private int recipientAccno;          
	private int amountToTransfer;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res; 
	private Timestamp transactionDate;  
	private int id;
	private int senderAccno;
	private int amount;
	private int loanAmount;
	private int tenure;
	private String purpose;
	private String status;
	private Timestamp appliedAt;
	private Timestamp approvedAt;
	private String adminRemark;
	private int cibilScore;

	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getAppliedAt() {
		return appliedAt;
	}
	public void setAppliedAt(Timestamp appliedAt) {
		this.appliedAt = appliedAt;
	}
	public Timestamp getApprovedAt() {
		return approvedAt;
	}
	public void setApprovedAt(Timestamp approvedAt) {
		this.approvedAt = approvedAt;
	}
	public String getAdminRemark() {
		return adminRemark;
	}
	public void setAdminRemark(String adminRemark) {
		this.adminRemark = adminRemark;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderAccno() {
		return senderAccno;
	}
	public void setSenderAccno(int senderAccno) {
		this.senderAccno = senderAccno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getRecipientAccno() {
		return recipientAccno;
	}
	public void setRecipientAccno(int recipientAccno) {
		this.recipientAccno = recipientAccno;
	}
	public int getAmountToTransfer() {
		return amountToTransfer;
	}
	public void setAmountToTransfer(int amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}
	public String getNpassword() {
		return npassword;
	}
	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhn() {
		return phn;
	}
	public void setPhn(long phn) {
		this.phn = phn;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Model() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(Credentials.url,Credentials.user,Credentials.pwd);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean registerUser() {
		try {
			String sql = "insert into bankapp(uname,accno,email,phone,balance,password) values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,uname);
			pstmt.setInt(2,accno);
			pstmt.setString(3,email);
			pstmt.setLong(4,phn);
			pstmt.setInt(5,balance);
			pstmt.setString(6,password);

			int x= pstmt.executeUpdate();

			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateUser() {
		try {
			String sql = "UPDATE bankapp SET uname = ?, email = ?, phone = ?, balance = ?, password = ? WHERE accno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, email);
			pstmt.setLong(3, phn);
			pstmt.setInt(4, balance);
			pstmt.setString(5, password);
			pstmt.setInt(6, accno);

			int x = pstmt.executeUpdate();

			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean deleteUser() {
		try {
			String sql = "DELETE FROM bankapp WHERE accno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accno);

			int x = pstmt.executeUpdate();

			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean LoginUser() {
		String sql="select * from bankapp where email=? and password=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			if(res.next()==true) {
				accno = res.getInt("accno");
				return true;
			}
			else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	public boolean fetchBalance() {
		try {
			String query = "select balance from bankapp where accno=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, accno);
			res = pstmt.executeQuery();
			while(res.next()==true) {
				balance = res.getInt("balance");
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}

	}

	public boolean changePassword() {
		try {
			String sql="update bankapp set password=? where accno=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, npassword);
			pstmt.setInt(2, accno);
			pstmt.setString(3, password);

			int x=pstmt.executeUpdate();
			if(x>0) {
				return true; 
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean transferBalance() {
		try {
			con.setAutoCommit(false);  // Begin transaction

			// 1. Get sender's balance
			String getSenderBalanceSQL = "SELECT balance FROM bankapp WHERE accno = ?";
			pstmt = con.prepareStatement(getSenderBalanceSQL);
			pstmt.setInt(1, accno); // accno = sender's account number
			res = pstmt.executeQuery();

			if (!res.next()) {
				con.rollback();
				return false; // sender not found
			}

			int senderBalance = res.getInt("balance");

			if (senderBalance < amountToTransfer) {
				con.rollback();
				return false; // insufficient funds
			}

			// 2. Check recipient account exists
			String checkRecipientSQL = "SELECT accno FROM bankapp WHERE accno = ?";
			pstmt = con.prepareStatement(checkRecipientSQL);
			pstmt.setInt(1, recipientAccno);
			res = pstmt.executeQuery();

			if (!res.next()) {
				con.rollback();
				return false; // recipient not found
			}

			// 3. Debit sender
			String debitSQL = "UPDATE bankapp SET balance = balance - ? WHERE accno = ?";
			pstmt = con.prepareStatement(debitSQL);
			pstmt.setInt(1, amountToTransfer);
			pstmt.setInt(2, accno);
			int debitResult = pstmt.executeUpdate();

			// 4. Credit recipient
			String creditSQL = "UPDATE bankapp SET balance = balance + ? WHERE accno = ?";
			pstmt = con.prepareStatement(creditSQL);
			pstmt.setInt(1, amountToTransfer);
			pstmt.setInt(2, recipientAccno);
			int creditResult = pstmt.executeUpdate();

			String insertTxn = "INSERT INTO transaction(sender_accno, recipient_accno, amount) VALUES (?, ?, ?)";
			pstmt = con.prepareStatement(insertTxn);
			pstmt.setInt(1, accno);
			pstmt.setInt(2, recipientAccno);
			pstmt.setInt(3, amountToTransfer);
			int insertResult = pstmt.executeUpdate();

			if (insertResult == 0) {
				con.rollback();
				return false;
			}


			if (debitResult > 0 && creditResult > 0) {
				con.commit();
				return true;
			} else {
				con.rollback();
				return false;
			}
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
	}

	// Method to generate random CIBIL score between 630 and 760
	public int generateRandomCibilScore() {
		int min = 630;
		int max = 760;
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	// Apply for loan
	public boolean applyLoan() {
	    try {
	        cibilScore = generateRandomCibilScore();

	        String sql = "INSERT INTO loan_applications (accno, amount, tenure, purpose, status, applied_at, cibil_score) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, accno);
	        pstmt.setInt(2, loanAmount);
	        pstmt.setInt(3, tenure);
	        pstmt.setString(4, purpose);
	        pstmt.setString(5, "Pending");
	        pstmt.setInt(6, cibilScore);

	        int x = pstmt.executeUpdate();
	        System.out.println("Loan application inserted rows: " + x);
	        if(x > 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	// Get pending loan applications
	public List<LoanApplication> getPendingLoanApplications() {
		List<LoanApplication> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM loan_applications WHERE status = 'Pending'";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			while (res.next()) {
				LoanApplication la = new LoanApplication();
				la.setId(res.getInt("id"));
				la.setAccno(res.getInt("accno"));
				la.setAmount(res.getInt("amount"));
				la.setTenure(res.getInt("tenure"));
				la.setPurpose(res.getString("purpose"));
				la.setStatus(res.getString("status"));
				la.setAppliedAt(res.getTimestamp("applied_at"));
				la.setAdminRemark(res.getString("admin_remark"));
				la.setApprovedAt(res.getTimestamp("approved_at"));
				la.setCibilScore(res.getInt("cibil_score")); 
				list.add(la);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// Update loan status after admin decision
	public boolean updateLoanStatus(int loanId, String newStatus, String remark) {
		try {
			String sql;
			if ("Approved".equalsIgnoreCase(newStatus)) {
				sql = "UPDATE loan_applications SET status = ?, admin_remark = ?, approved_at = CURRENT_TIMESTAMP WHERE id = ?";
			} else {
				sql = "UPDATE loan_applications SET status = ?, admin_remark = ?, approved_at = NULL WHERE id = ?";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newStatus);
			pstmt.setString(2, remark);
			pstmt.setInt(3, loanId);
			int x = pstmt.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
