#include<iostream>

using namespace std;

void merge(int* arr, int l, int m, int r);
int min(int a,int b)
{
	return a < b ? a : b;
}
void mergeSort(int* arr, int N)
{
	for (int unit = 1; unit < N; unit *= 2)
	{
		for (int left_start = 0; left_start < N-1; left_start += 2*unit)
		{
			int mid = min(N - 1, left_start + unit - 1);
			int right_end = min(N - 1, left_start + 2 * unit - 1);
			merge(arr, left_start, mid, right_end);
		}

        // cout<<"정렬 확인: ";
	    // for (int i = 0; i < N; i++)
	    // {
		//     cout << arr[i] << " ";
	    // }
        // cout<< endl;
	}
}

void merge(int* arr,int l,int m, int r)
{
	int n1 = m - l + 1;
	int n2 = r - m;

	int* L = new int[n1];
	int* R = new int[n2];

	for (int i = 0; i < n1; i++)
	{
		L[i] = arr[l + i];
	}
	for (int i = 0; i < n2; i++)
	{
		R[i] = arr[m + 1 + i];
	}

	int i = 0, j = 0, k = l;
	while (i < n1 && j < n2)
	{
		if (L[i] <= R[j])
		{
			arr[k++] = L[i++];
		}
		else
		{
			arr[k++] = R[j++];
		}
	}

	while (i < n1)
	{
		arr[k++] = L[i++];
	}
	while (j < n2) 
	{
		arr[k++] = R[j++];
	}

    delete[] L;
    delete[] R;
}

bool binSearch(int* arr,int N,int num)
{
	int l = 0;
	int r = N-1;
	
	while (l<=r)
	{
		int m = l+(r-l)/ 2;
		if (arr[m] == num)
		{
			return true;
		}
		else if (arr[m] < num)
		{
			l = m+1;
		}
		else
		{
			r = m - 1;
		}
	}
	return false;
}

int main(int argc, char** argv)
{
    cin.tie(NULL);

	int N,M;
	cin >> N;
	
	int* arr=new int[N];

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	mergeSort(arr, N);

    // cout<<"정렬완료 확인: ";
	// for (int i = 0; i < N; i++)
	// {
	// 	cout << arr[i] << " ";
	// }
    // cout<< endl;

	cin >> M;
	for (int i = 0; i < M; i++)
	{
		int num;
		cin >> num;
		if (binSearch(arr, N, num))
		{
			cout << "1\n";
		}
		else
		{
			cout << "0\n";
		}
	}
    delete[] arr;

}