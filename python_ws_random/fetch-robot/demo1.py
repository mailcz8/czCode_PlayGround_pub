

numbers = ['sunday']
numbers1 = [1,2,3,4,5,6,7,8,9]


def get_largest(data):
    try:
        if len(data) == 0:
            return 0
        else:
            largest_num_found = int(max(data))
            return largest_num_found
    except:
        print('Input {}, please enter int only'.format(data))

print(get_largest(numbers))
# print(get_largest(numbers1))

''' 2nd question: 
https://helloacm.com/comparing-left-and-right-branch-of-a-complete-binary-tree/
const solution = (arr) => {
    if (!arr) return "";
    if (arr.length === 0) return "";
    const sum = (arr, idx) => {
        if (idx - 1 < arr.length) {
            if (arr[idx - 1] === -1) return 0;
            return arr[idx - 1] + sum(arr, idx * 2) + sum(arr, idx * 2 + 1);
        }
        return 0;
    };
    const left = sum(arr, 2);
    const right = sum(arr, 3);
    return (left == right) ? "" : (left > right ? "Left" : "Right");
};
'''