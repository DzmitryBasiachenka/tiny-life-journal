package liquibase

databaseChangeLog {
    includeAll(path: 'tlj-db/src/main/resources/liquibase/changelogs', relativeToChangelogFile: false)
}
