databaseChangeLog {

    changeSet(id: '00002', author: 'dzmitry') {
        insert(tableName: 'user') {
            column(name: 'id', value: '11123005va')
            column(name: 'name', value: 'admin')
            column(name: 'login', value: 'dzmitry')
            column(name: 'password', value: "b6e79dc4288af2421c39fe2d805ae596")
        }

        insert(tableName: 'article') {
            column(name: 'id', value: 'adminId')
            column(name: 'title', value: 'title')
            column(name: 'text', value: 'text')
            column(name: 'userId', value: '11123005va')
        }

        rollback {
            delete(tableName: 'user') {
                where "id = '11123005va'"
            }
            delete(tableName: 'article') {
                where "id = 'adminId'"
            }
        }
    }
}
