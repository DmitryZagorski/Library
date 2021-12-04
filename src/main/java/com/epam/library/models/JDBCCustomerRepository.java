package com.epam.library.models;

import com.epam.configurations.Configuration;
import com.epam.library.connections.ConnectionPoolProvider;
import com.epam.library.exceptions.CustomerException;
import com.epam.library.exceptions.CustomerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class JDBCCustomerRepository implements CustomerRepository {

    private static final Logger Log = LoggerFactory.getLogger(JDBCCustomerRepository.class);

    private static JDBCCustomerRepository instance;

    public JDBCCustomerRepository() {

    }

    public static synchronized JDBCCustomerRepository getInstance() {
        if (instance == null) {
            instance = new JDBCCustomerRepository();
        }
        return instance;
    }

    @Override
    public void addCustomer(Customer customer) {
        String insertNewCustomer = "insert into customers (name, surname, birth, address) values (?,?,?,?)";
        try (Connection connection = ConnectionPoolProvider.getConnection();
             PreparedStatement prStatement = connection.prepareStatement(insertNewCustomer)) {
            prStatement.setString(1, customer.getName());
            prStatement.setString(2, customer.getSurname());
            prStatement.setDate(3, customer.getBirth());
            prStatement.setString(4, customer.getAddress());
            int result = prStatement.executeUpdate();
            if (result != 1) {
                throw new CustomerException("Customer was not added!");
            }
        } catch (SQLException e) {
            Log.error("Something wrong during adding customer", e);
            throw new CustomerException(e);
        }
    }

    @Override
    public void removeCustomerById(Integer id) {
        String findCustomer = "select * from customers where id = ".concat(id.toString());
        String removeCustomer = "delete from customers where id = ".concat(id.toString());

        try (Connection connection = ConnectionPoolProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(findCustomer)) {
            if (resultSet.next()) {
                statement.execute(removeCustomer);
            } else {
                Log.info("Customer with that ID doesn't exist.");
            }
        } catch (SQLException e) {
            Log.error("Something wrong during removing customer by id " + id, e);
            throw new CustomerException();
        }
    }

    @Override
    public void removeAllCustomers() {
        String removeAllCustomers = "delete from customers";
        try (Connection connection = ConnectionPoolProvider.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(removeAllCustomers);
        } catch (SQLException e) {
            Log.error("Something wrong during removing all customers", e);
            throw new CustomerException(e);
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {
        String getById = "select * from customers where id = ".concat(id.toString());
        try (Connection connection = ConnectionPoolProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getById)) {
            if (resultSet.next()) {
                Customer customer = getCustomer(resultSet);
                return customer;
            } else {
                return null;
            }
        } catch (SQLException e) {
            Log.error("Something wrong during retrieval id " + id, e);
            throw new CustomerNotFoundException(id, e);
        }
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        String getAllCustomers = "select * from customers";
        try (Connection connection = ConnectionPoolProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAllCustomers)) {
            List<Customer> customerList = new ArrayList<>();
            while (resultSet.next()) {
                customerList.add(getCustomer(resultSet));
            }
            return customerList;
        } catch (SQLException e) {
            Log.error("Something wrong during getting all customers", e);
            throw new CustomerException(e);
        }
    }

    private Customer getCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setName(resultSet.getString("name"));
        customer.setSurname(resultSet.getString("surname"));
        customer.setBirth(resultSet.getDate("birth"));
        customer.setAddress(resultSet.getString("address"));
        return customer;
    }
}
