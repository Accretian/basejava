import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    //очищаем массив резюме
    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    //сохранем новое резюме в массив, если в нем есть место, в конец после других резюме
    void save(Resume r) {
        if (size() < 10000) {
            storage[size()] = r;
        }
    }

    //возвращаем резюме по uuid или null, если резюме по uuid не найдено
    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    // удаляем резюме с указанным uuid. Если в массиве после удаленного элемента есть другие резюме, перемещаем их в массиве на одну ячейку к началу массива
    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                while (i + 1 < 10000 && storage[i + 1] != null) {
                    storage[i] = storage[i + 1];
                    storage[i + 1] = null;
                    i++;
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size() != 0) {
            return Arrays.copyOfRange(storage, 0, size());
        } else {
            return new Resume[0];
        }
    }

    // вычисляем количество резюме в массиве
    int size() {
        int i = 0;
        while (i <= 10000 && storage[i] != null) {
            i++;
        }
        return i;
    }
}
