package app.repo.account;

import app.entity.account.AccountEntity;
import app.repo.WriteOnlyRepository;

public interface AccountWriteOnlyRepository extends WriteOnlyRepository<AccountEntity, String> {
}
