package liquibase

databaseChangeLog {
    changeSet(id: 'ms-000000', author: 'dzmitry', runInTransaction: 'false') {
        sql() {
            "create database tiny_life_journal with owner=postgres encoding='UTF8'"
        }
    }
}
