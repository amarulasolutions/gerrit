import com.google.gerrit.server.project.NoSuchChangeException;
    PushOneCommit create(
        ReviewDb db,
        PersonIdent i,
        TestRepository<?> testRepo,
        @Assisted("changeId") String changeId);

  @AssistedInject
  PushOneCommit(ChangeNotes.Factory notesFactory,
      ApprovalsUtil approvalsUtil,
      Provider<InternalChangeQuery> queryProvider,
      @Assisted ReviewDb db,
      @Assisted PersonIdent i,
      @Assisted TestRepository<?> testRepo,
      @Assisted("changeId") String changeId) throws Exception {
    this(notesFactory, approvalsUtil, queryProvider,
        db, i, testRepo, SUBJECT, FILE_NAME, FILE_CONTENT, changeId);
  }

      .committer(new PersonIdent(i, testRepo.getDate()));
  public void noParents() {
    commitBuilder.noParents();
  }

        throws OrmException, NoSuchChangeException {
        throws OrmException, NoSuchChangeException {
      Iterable<Account.Id> actualIds = approvalsUtil
          .getReviewers(db, notesFactory.createChecked(db, c))
          .values();