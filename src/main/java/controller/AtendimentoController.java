/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.AtendimentoModel;
import util.ConnectionFactory;

/**
 *
 * @author jonathandamasiomedeiros
 */
public class AtendimentoController {

    public int save(AtendimentoModel atendimentoModel) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(atendimentoModel);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return atendimentoModel.getId();
    }

    public List<AtendimentoModel> getAll() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query query = entityManager.createQuery("from AtendimentoModel");
            return query.getResultList();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public AtendimentoModel getFirst() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query query = entityManager.createQuery("from AtendimentoModel where status = 0 order by id asc");
            query.setMaxResults(1);

            return (AtendimentoModel) query.getSingleResult();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public List<AtendimentoModel> getNextList() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query query = entityManager.createQuery("from AtendimentoModel where status = 0 order by id asc");
            query.setMaxResults(3);

            return query.getResultList();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public List<AtendimentoModel> getChamadosList() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query query = entityManager.createQuery("from AtendimentoModel where status = 2 order by id desc");
            query.setMaxResults(3);

            return query.getResultList();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public AtendimentoModel getChamado() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query query = entityManager.createQuery("from AtendimentoModel where status = 1 order by id asc");
            query.setMaxResults(1);

            return (AtendimentoModel) query.getSingleResult();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void updateJaAtendido() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("update AtendimentoModel set status = 2 where status = 1");
        entityManager.getTransaction().begin();
        query.executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public void update(AtendimentoModel atendimentoModel) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(atendimentoModel);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
