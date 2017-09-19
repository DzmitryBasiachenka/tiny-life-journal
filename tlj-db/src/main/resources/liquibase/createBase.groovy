package liquibase

databaseChangeLog {
    changeSet(id: 'ms-000000', author: 'dzmitry', runInTransaction: 'false') {
        sql() {
            "create database tiny-life-journal with owner=postgres encoding='UTF8'"
        }
    }
}
