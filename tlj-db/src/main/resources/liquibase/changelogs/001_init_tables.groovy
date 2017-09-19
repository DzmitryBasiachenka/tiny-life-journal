databaseChangeLog {
    
 changeSet(id: '00001', author: 'dzmitry') {
        comment "Create user table"

        createTable(tableName: 'user') {
            column(name: 'id', type: 'VARCHAR(128)') {
                constraints(primaryKey: true, primaryKeyName: 'id')
            }
            column(name: 'name', type: 'VARCHAR(256)') {
                constraints(nullable: false)
            }
			column(name: 'login', type: 'VARCHAR(64)') {
                constraints(nullable: false, unique: true, uniqueConstraintName: 'UIX_USERS_LOGIN')
            }
            column(name: 'password', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
		}
        rollback {
            // automatic rollback
        }
}
 
 changeSet(id: '00002', author: 'dzmitry') {
        comment "Create article table"

        createTable(tableName: 'article') {
            column(name: 'id', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
            column(name: 'title', type: 'VARCHAR(256)') {
                constraints(nullable: false)
            }
            column(name: 'text', type: 'VARCHAR') {
                constraints(nullable: false)
            }
            column(name: 'userId', type: 'VARCHAR(128)') {
                constraints(nullable: false)
            }
        }

        rollback {
            // automatic rollback
        }
 }
 
 changeSet(id: '00003', author: 'dzmitry') {
     addPrimaryKey(tableName: 'article', columnNames: 'id', constraintName: 'pk_article')

     addForeignKeyConstraint(constraintName: 'fk_article_userId',
                baseTableName: 'article', baseColumnNames: 'userId',
                referencedTableName: 'user', referencedColumnNames: 'id')
 }
}
