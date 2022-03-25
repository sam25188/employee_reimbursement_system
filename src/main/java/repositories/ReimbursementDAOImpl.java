package repositories;

import models.Reimbursement;
import util.ConnectionUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{


    @Override
    public List<Reimbursement>getReimbursementById(Integer userId) {
        List<Reimbursement>lists = new ArrayList<>();
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from ers_reimbursement er where reimb_author= ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lists.add(new Reimbursement(
                 rs.getInt(1),
                 rs.getInt(2)
                ));
            }


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return lists;
    }

    @Override
    public void createReimbursement(Reimbursement reimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into ers_reimbursement (reimb_amount, reimb_author, reimb_type_id)\n" +
                    "values (?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getAmount());
            ps.setInt(2, reimbursement.getUserId());
            ps.setInt(3, reimbursement.getTypeId());

            ps.executeUpdate();

            }catch (SQLException sqle){
                sqle.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement>getAllReimbursements() {
        List<Reimbursement>lists = new ArrayList<>();
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from ers_reimbursement;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lists.add(new Reimbursement(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getTimestamp(3),
                        rs.getTimestamp(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return lists;
    }

    @Override
    public void update(Integer reimbursementId, Integer resolverId, Integer statusId) {


        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update ers_reimbursement set reimb_resolved = current_timestamp, reimb_resolver = ?, reimb_status_id = ? where Reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, resolverId);
            ps.setInt(2, statusId);
            ps.setInt(3, reimbursementId);

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> getReimbursementByStatusId() {
        List<Reimbursement> lists = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from ers_reimbursement order by reimb_status_id desc;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lists.add(new Reimbursement(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getTimestamp(3),
                        rs.getTimestamp(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return lists;
    }
}
