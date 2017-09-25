package app.repo.account;

import app.entity.account.AccountEntity;
import app.repo.ReadOnlyRepository;

public interface AccountReadOnlyRepository extends ReadOnlyRepository<AccountEntity, String> {
}
